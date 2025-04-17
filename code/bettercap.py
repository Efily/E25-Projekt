import pexpect
import re
import time

# Function to parse bettercap output
def parse_bettercap_output(output):
    try:
        print("Parsing Bettercap Output:")
        print(output)
        
        # Regular expression to match MAC addresses and their corresponding dBm values
        pattern = re.compile(r'([0-9A-Fa-f]{2}(:[0-9A-Fa-f]{2}){5}).*?(-\d+ dBm)')
        
        matches = pattern.findall(output)
        
        if matches:
            print("MAC Addresses and dBm values found:")
            devices = []
            for match in matches:
                mac_address = match[0]
                dBm = int(match[2].split()[0])  # Convert dBm to an integer
                print(f"MAC Address: {mac_address}, dBm: {dBm}")
                devices.append((mac_address, dBm))
            
            # Find the device with the strongest signal (closest to 0 dBm)
            strongest_device = max(devices, key=lambda x: x[1])
            return strongest_device[0]
        else:
            return None
        
    except Exception as e:
        print(f"Error parsing Bettercap output: {e}")
        return None

def read_all_output(child):
    output = ""
    while True:
        try:
            output += child.read_nonblocking(size=4096, timeout=1)
        except pexpect.TIMEOUT:
            break
        except pexpect.EOF:
            break
    return output

def start_bettercap():
    strongest_mac = None
    try:
        # Start bettercap with sudo
        child = pexpect.spawn('sudo bettercap', encoding='utf-8')
        time.sleep(3)  # Wait a bit for bettercap to start

        # Enable BLE recon
        child.sendline('ble.recon on')
        time.sleep(20)  # Wait longer for the recon to collect some data

        # Capture the output and parse it
        output = read_all_output(child)

        if output:
            strongest_mac = parse_bettercap_output(output)
            
            if strongest_mac:
                print(f"Executing enumeration on MAC: {strongest_mac}")
                child.sendline(f'ble.enum {strongest_mac}')
                time.sleep(20)  # Wait for 20 seconds to collect the enumeration output

                # Read the enumeration output
                enum_output = read_all_output(child)
                if enum_output:
                    print("Enumeration Output:")
                    print(enum_output)
                else:
                    print("No enumeration output received.")
            else:
                print("No strong MAC address found.")
        else:
            print("No output received from bettercap.")
            
    except KeyboardInterrupt:
        print("Stopping Bettercap...")
        child.sendline('exit')
        child.close()
        print("Bettercap stopped.")
    except Exception as e:
        print(f"An error occurred: {e}")
    finally:
        if strongest_mac:
            print({strongest_mac})
        else:
            print("No MAC address detected.")

if __name__ == "__main__":
    start_bettercap()
