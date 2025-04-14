#Målsætning

#Delmål: 
#🔹 1. Research & Planlægning:
##Forstå Bluetooth-sikkerhed og eksisterende sårbarheder (f.eks. BlueBorne, KNOB attack, BLE MITM-angreb). Undersøg eksisterende pentesting-værktøjer som Bettercap, hcxdumptool, bluesniff, gattacker osv. Definér scope: ##Skal du teste BLE (Bluetooth Low Energy) eller klassisk Bluetooth? Skal det være en passiv eller aktiv test? 
#🔹 2. Udvælgelse af Værktøjer & Opsætning Vælg et programmeringssprog til at bygge min test suite (Python): 
##Opsæt et miljø til pentesting, f.eks. en Raspberry Pi eller en Kali Linux VM.333 Sørg for en Bluetooth-dongle, der understøtter sniffing og aktiv scanning (f.eks. Ubertooth One eller en CSR 4.0 USB dongle). 
#🔹 3. Grundlæggende Bluetooth Analyse Scan efter enheder i nærheden og log MAC-adresser og enhedstyper: 
##Prøv at hente enhedens navn, service UUIDs og andre detaljer via hcitool eller btmon. Test for ukrypterede dataoverførsler ved at sniffe Bluetooth-trafik. 
#🔹 4. Automatisering af Pentesting Tests Byg et script til automatiseret scanning og identifikation af enheder. 
##Implementér kendte angreb, f.eks.: Man-in-the-Middle (MITM) angreb på BLE-forbindelser. Brute-force af pairing-koder (PIN cracking). Denial of Service (DoS) angreb (f.eks. overbelastning med “L2CAP Echo Requests”). 
#🔹 5. Rapportering & Visualisering:
##Lav en log-fil eller en web-GUI, der viser sårbare enheder og testresultater. Generér en rapport med fundne sårbarheder, eventuelle CVE’er og anbefalinger til forbedring. 
#🔹 6. Publicering på GitHub Pages Dokumentér hele processen på min GitHub Page. 
##Upload kode og test-eksempler. Inkludér en guide til at bruge test suiten.
