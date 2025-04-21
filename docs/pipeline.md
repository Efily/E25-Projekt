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
apps til at lave phishing attacks eller andet. Derudover med mac addresserne hvis en f.eks er ved at pair med en anden device kan vi lave en MITM attack. Derved at at samle disse mac addresser meget vigtigt.   

##Bettercap Python Kode  
![Bettercap Python code 1/2](images/Bettercap1.png)  
![Bettercap Python code 2/2](images/Bettercap2.png)  
##Jenkins Groovy Kode  
![Jenkins Groovy code 1/2](images/Jenkins1.png)  
![Jenkins Groovy code 2/2](images/Jenkins2.png)  
