import java.io.File;

class Siblings {

    public static boolean areSiblings(File f1, File f2) {
        String f1p = f1.getParent();
        String f2p = f2.getParent();
        boolean sameParent;
        if (f1p.equals(f2p)) {
            sameParent = true;
        } else {
            sameParent = false;
        }

        return sameParent;
    }
}