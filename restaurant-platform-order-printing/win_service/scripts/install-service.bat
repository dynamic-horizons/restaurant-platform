OrderPrintingService //IS//OrderPrintingService --DisplayName="Restaurant_Platform_Order_Printing_Service" ^
 --Classpath "resources;libs/*" --JavaHome "C:\Program Files\Java\jdk1.7.0_04" --Jvm "C:\Program Files\Java\jdk1.7.0_04\jre\bin\server\jvm.dll" ^
 --StartMode=jvm --StopMode=jvm --StdOutput C:\OPR\logs\stdout.log --StdError C:\OPR\logs\stderr.log ^
 --StartClass=net.dynamichorizons.rp.print.OrderPrinterDaemon --StartMethod windowsService --StartParams start ^
 --StopClass=net.dynamichorizons.rp.print.OrderPrinterDaemon --StopMethod windowsService --StopParams  stop ^
 --LogPath C:\OPR\logs --LogPrefix rp-daemon --LogLevel debug