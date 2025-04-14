##Indhold  
I mit projekt vil jeg gerne kigge på bluetooth pentesting og pipelines og hvilke værktøjer gøres der brug af. Mit mål vil være opdelt i tre dele:

Opnå en større faglighed i brugen af pentesting værktøjer til bluetooth  
Opnå en større faglighed i brugen af CI/CD Pipeline  
Finde frem til, hvilken værdi pentesting har i it-sikkerheds verdenen i dag, specielt inden for Bluetooth  

For at åbnå disse mål har jeg sat op nogen læringsmål til at opnå dette samt nogen delmål som er en god måde at gå fremad  

##Læringsmål

Den studerende opsætter selv læringsmål (skabelon herunder) ud fra det valgte emne og indenfor rammerne i uddannelsens mål for læringsudbytte fra den nationale studieordning kapitel 1, se: https://esdhweb.ucl.dk/D22-1980440.pdf

Det er ikke alle læringsmål der skal opfyldes, vælg dem der passer til det valgte fordybelsesområde.

Læringsmål skal ordnes efter viden, færdigheder og kompetencer  

**Viden**

Den studerende har viden om...

Pentesting værktøjer til bluetooth
Gængse metoder og fremgangsmåder hvorved pentesting udføres
Gængse metoder og fremgangsmåder hvorved CI/CD Pipeline udføres

**Færdigheder**

Den studerende kan...

Udføre pentesting angreb
Udføre pentesting med brug af en Pipeline (CI/CD)
Vurdere effektiviteten af pentesting angreb, baseret på tid, ressourcer og resultater
Skrive en rapport baseret på resultaterne af en pentest

**Kompetencer**

Den studerende kan...

håndtere udarbejdelsen og dokumentation af en pentest proces
sammenkoble værktøjer til at opnå resultater

##Delmål

🔹 1. Research & Planlægning  
Forstå Bluetooth-sikkerhed og eksisterende sårbarheder (f.eks. BlueBorne, KNOB attack, BLE MITM-angreb). Undersøg eksisterende pentesting-værktøjer som Bettercap, hcxdumptool, bluesniff, gattacker osv. Definér scope: Skal du teste BLE (Bluetooth Low Energy) eller klassisk Bluetooth? Skal det være en passiv eller aktiv test?  

🔹 2. Udvælgelse af Værktøjer Opsætning   
Vælg et programmeringssprog til at bygge min test suite (Python). Opsæt et miljø til pentesting, f.eks. en Raspberry Pi eller en Kali Linux VM.333 Sørg for en Bluetooth-dongle, der understøtter sniffing og aktiv scanning (f.eks. Ubertooth One eller en CSR 4.0 USB dongle).  

🔹 3. Grundlæggende Bluetooth Analyse  
Scan efter enheder i nærheden og log MAC-adresser og enhedstyper. Prøv at hente enhedens navn, service UUIDs og andre detaljer via hcitool eller btmon. Test for ukrypterede dataoverførsler ved at sniffe Bluetooth-trafik.  

🔹 4. Automatisering af Pentesting Tests  
Byg et script til automatiseret scanning og identifikation af enheder. Implementér kendte angreb, f.eks.: Man-in-the-Middle (MITM) angreb på BLE-forbindelser. Brute-force af pairing-koder (PIN cracking). Denial of Service (DoS) angreb (f.eks. overbelastning med “L2CAP Echo Requests”).  

🔹 5. Rapportering & Visualisering  
Lav en log-fil eller en web-GUI, der viser sårbare enheder og testresultater. Generér en rapport med fundne sårbarheder, eventuelle CVE’er og anbefalinger til forbedring. 

🔹 6. Publicering på GitHub Pages  
Dokumentér hele processen på min GitHub Page. Upload kode og test-eksempler. Inkludér en guide til at bruge test suiten.  
