##CI/CD Bluetooth Recon Penetration Projekt
**OBS:** Koden og lidt forklaring til koden kan findes i bunden af siden.  

##Terminal Python Script  
![Run Python Script](images/TerminalPython.png)  
Efter at lave skriptet med mange forsøg for at få det hele til at fungere specielt med en regular expression,  
kan scriptet starte Bettercap og en ble recon for a kigge efter devices og deres mac addresse samt signal styrken og hvilken form for enhed det er.
Som set på billedet over så kan jeg se en masse apple produkter (højst sansyneligt iphones) der efter vil den liste dem alle ud som den har opsnappet  
og så vælge den med den stærkeste signal styrke da det er højest success at enumerate til som den så vil enumerate til og derefter poste hvad information den får ved at "connect" til den.  
Det der er vigtigt at forstå er at brugeren på den device som den connecter til VIL IKKE få at vide at de er blevet enumerated da det som den gør er at spørge efter dens GATT profil (Generic Attribute Table), som er  
hvor den basically spørger om ALT som den device har til rådighed. Derefter vil vi disconnect for ikke at vække noget suspicon og så får vi en masse information som KAN blive bruge til exploitations hvis man er en  
trusselaktør, f.eks. denne telefon som vi connecter til (min mors telefon som jeg fik lov til at bruge til min fremvisning) har WRITE og NOTIFY og READ properties som tillader os at gøre nogen ting gennem bettercap som man kan passe på med, da vi kan write og notify til "Apple Notification Center Service" hvor vi kan sende falske notifikationer måske endda med harmlig kode hvis de trykker på notifikationen, som kan blive brugt med  
apps til at lave phishing attacks eller andet. Derudover med mac addresserne hvis en f.eks er ved at pair med en anden device kan vi lave en MITM attack. Derved at at samle disse mac addresser meget vigtigt. I mit projekt har jeg holdt mig til mere at lære hvordan man kan bruge bettercap med CI/CD så jeg har ikke haft tid til at lære hvordan jeg kunne lave en MITM attack men mere at det er muligt.   

##Config Jenkins
![Jenkins Config](PipelineScript.png)  
Efter at en et python script der virker sætter vi op en jenkins pipeline og configurer det med et CI/CD script som bruger stages til at gøre ting i forskellige rækkefølger.  
I mit projekt har jeg sat op 2 stages for at fremvise hvordan det fungerer hvor at vi har et stage som kører koden og bruger den information som scriptet giver, og selv inde i dette script kan vi køre kode som gør at stagen kan køre igen og igen indtil vi får hvad vi leder efter og gemmer den information som vi vil bruge hvis vi havde flere scripts til exploits vi kunne bruge den device vi har fundet til at teste for en masse kendte exploits. Og i anden stage confirmer vi at den device vi har sagt er god til at teste for exploits er gemt til fremtidig brug, dette ville betyde mere i en test suite environment for et firma som gerne ville pent teste deres devices eller hobby cybersikkerhed arbejdere som er intereseret i at teste deres egne devices. (Bettercap can bruge både bluetooth og wifi og mere).


##Bettercap Python Kode  
![Bettercap Python code 1/2](images/Bettercap1.png)  
![Bettercap Python code 2/2](images/Bettercap2.png)  
##Jenkins Groovy Kode  
![Jenkins Groovy code 1/2](images/Jenkins1.png)  
![Jenkins Groovy code 2/2](images/Jenkins2.png)  
