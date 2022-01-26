
import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Predator
 */
public class Item {
  private int id;
  private String description;

    public Item() {
    }

  
  public Item(int id, String description) {
    this.id = id;
    this.description = description;
  }

public void setId(int id) {
    this.id = id;
}

public void setDescription(String description) {
    this.description = description;
}

  public void set(int id, String description) {
    this.id = id;
    this.description = description;
  }
  
  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return description;
  }
    
}
class ItemRenderer extends BasicComboBoxRenderer {
  @Override
  public Component getListCellRendererComponent(JList list, Object value,
      int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected,
        cellHasFocus);
    if (value != null) {
      Item item = (Item) value;
      setText(item.getDescription().toUpperCase());
    }
    if (index == -1) {
      Item item = (Item) value;
      setText("" + item.getId());
    }
    return this;
  }
}