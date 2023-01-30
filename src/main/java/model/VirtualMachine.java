package model;

import java.util.Map;
import java.util.Set;

public class VirtualMachine {
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
