package mvc;

import java.io.Serializable;

public class Model extends Publisher implements Serializable {
    private boolean unsavedChanges = false;
    public String fileName = null;

    public Model() {
    }

    public void changed(){
        // firePropertyChange(null, null, null);
        this.unsavedChanges = true;
        this.notifySubscribers();
    }

    public String getFileName(){
        return fileName;
    }

    public void setFileName(String name){
        this.fileName = name;
    }

    public void setUnsavedChanges(boolean b) {
        unsavedChanges = b;
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }
}