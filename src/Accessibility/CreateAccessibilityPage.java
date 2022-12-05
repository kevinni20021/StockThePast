package Accessibility;

import javafx.stage.Modality;
import javafx.stage.Stage;



public class CreateAccessibilityPage {
    AccessibilityPage page;

    public CreateAccessibilityPage(AccessibilityPage page){
        this.page = page;
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(this.page.stage);
    }

}


