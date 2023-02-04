package model;

import utils.ObjectPlus;

public class VirtualMachine extends ObjectPlus {
    private String vmName;
    private float vmDiskSize;
    private float vmCPUAssigned;

    private Server vmServer;

    /**
     * Konstruktor
     *
     * @param vmName        Nazwa maszyny
     * @param vmDiskSize    Rozmiar dysku VHD
     * @param vmCPUAssigned Przypisane CPU
     */
    private VirtualMachine(String vmName, float vmDiskSize, float vmCPUAssigned, Server vmServer) {
        this.vmName = vmName;
        this.vmDiskSize = vmDiskSize;
        this.vmCPUAssigned = vmCPUAssigned;
        this.vmServer = vmServer;
    }

    /**
     * Metoda tworząca maszynę wirtualną w obrębie serwera
     * @param vmName Nazwa maszyny
     * @param vmDiskSize Rozmiar dysku VHD
     * @param vmCPUAssigned Przypisane CPU
     * @param vmServer serwer do któego ma być przypisana maszyna wirtualna
     * @return obiekt maszyny wirtualnej
     * @throws Exception jeśli próba przypisania maszyny do nieistniejącego serwera
     */
    public static VirtualMachine CreateVirtualMachine(String vmName, float vmDiskSize, float vmCPUAssigned, Server vmServer) throws Exception {
        if(vmServer == null){
            throw new Exception("Podany serwer nie istnieje");
        }

        // Utworzenie części
        VirtualMachine vm = new VirtualMachine(vmName, vmDiskSize, vmCPUAssigned, vmServer);

        vmServer.addVMToServer(vm);

        return vm;
    }

}
