import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class RefuserCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    private boolean refus;
    private JButton bouton;
 
    public RefuserCellEditor() {
        super();
 
        bouton = new JButton("Refuser");
        bouton.addActionListener(this);
        bouton.setBorderPainted(false);
    }

    public Object getCellEditorValue() {
        return refus;
    }
 
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        refus = (Boolean)value;
 
        return bouton;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}