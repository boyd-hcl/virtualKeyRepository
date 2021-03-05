package VirtualKeyRepository;

//Instance of FileList class for virtual key project using singleton interface
public class VirtualKeyRepository extends FileList{
    private static VirtualKeyRepository vkr;
    private VirtualKeyRepository(){
        super();
    }
    public static VirtualKeyRepository getVirtualKeyRepository(){
        if(vkr == null){
            vkr = new VirtualKeyRepository();
        }
        return vkr;
    }
}