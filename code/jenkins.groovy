pipeline {
    agent any
    stages {
        stage('Execute Python Script') {
            steps {
                ansiColor('xterm') {
                    script {
                        boolean confirmed = false
                        boolean reuseMac = false

                        // Check if the mac_address.txt file exists and contains a MAC address
                        if (fileExists('mac_address.txt')) {
                            def existingMacAddress = readFile('mac_address.txt').trim()
                            if (existingMacAddress) {
                                // Ask the user if they want to reuse the existing MAC address
                                def userInput = input(
                                    id: 'reuseMacInput', message: 'A MAC address was found in mac_address.txt. Do you want to reuse it?',
                                    parameters: [
                                        [$class: 'TextParameterDefinition', defaultValue: "${existingMacAddress}", description: 'Existing MAC Address', name: 'MAC_ADDRESS'],
                                        [$class: 'BooleanParameterDefinition', defaultValue: false, description: '', name: 'REUSE']
                                    ]
                                )
                                reuseMac = userInput.REUSE
                                confirmed = reuseMac
                                if (reuseMac) {
                                    echo "Reusing MAC Address: ${existingMacAddress}"
                                }
                            }
                        }

                        while (!confirmed) {
                            // Print a message to indicate the script is running
                            echo 'Running Python script...'
                            
                            // Run the Python script and capture the output
                            sh 'python3 /home/kali/Desktop/Python/bettercap.py | tee script_output.txt'
                            
                            // Extract the last line from the output file and save it to another file
                            sh 'tail -n 1 script_output.txt > mac_address.txt'
                            
                            // Read and display the captured MAC address in the Jenkins console
                            def macAddress = readFile('mac_address.txt').trim()
                            echo "Captured MAC Address: ${macAddress}"
                            
                            // Ask the user if this is the MAC address to continue with
                            def userInput = input(
                                id: 'userInput', message: 'Is this the MAC address you want to continue with?',
                                parameters: [
                                    [$class: 'TextParameterDefinition', defaultValue: "${macAddress}", description: 'Captured MAC Address', name: 'MAC_ADDRESS'],
                                    [$class: 'BooleanParameterDefinition', defaultValue: false, description: '', name: 'CONFIRM']
                                ]
                            )
                            
                            // Check the user input
                            confirmed = userInput.CONFIRM
                            
                            if (!confirmed) {
                                echo 'Re-running the Python script to capture the MAC address again...'
                            }
                        }
                    }
                }
            }
        }
        stage('Read and Print MAC Address') {
            steps {
                script {
                    // Read the MAC address from the file
                    def macAddress = readFile('mac_address.txt').trim()
                    
                    // Check if the file is empty and print the appropriate message
                    if (macAddress) {
                        echo "MAC Address from file: ${macAddress}"
                    } else {
                        echo "File empty"
                    }
                }
            }
        }
    }
    post {
        always {
            // Archive the file containing the MAC address so it can be accessed later
            archiveArtifacts artifacts: 'mac_address.txt', allowEmptyArchive: true
        }
    }
}
