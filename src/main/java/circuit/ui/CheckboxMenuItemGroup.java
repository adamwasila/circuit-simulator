package circuit.ui;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Set;

public class CheckboxMenuItemGroup implements ItemListener
{

    private Set<CheckboxMenuItem> items = new HashSet<CheckboxMenuItem>();

    public void add(CheckboxMenuItem cbmi) {
        cbmi.addItemListener(this);
        cbmi.setState(false);
        items.add(cbmi);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {

            String itemAffected = (String)e.getItem();
            for (CheckboxMenuItem item : items) {
                if (item.getLabel() != itemAffected) item.setState(false);
            }
        }
    }

    public void selectItem(CheckboxMenuItem itemToSelect) {
        for (CheckboxMenuItem item : items) {
            item.setState(item == itemToSelect);
        }
    }

    public CheckboxMenuItem getSelectedItem() {
        for (CheckboxMenuItem item : items) {
            if (item.getState()) return item;
        }
        return null;
    }
}