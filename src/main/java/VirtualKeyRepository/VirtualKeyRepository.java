package VirtualKeyRepository;

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