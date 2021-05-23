package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class test extends JFrame {

    // column names
    private String[] columns = {"Name", "Last Name", "Job Title"};

    // row data
    private Object[][] data = {{"Carl", "Jonson", "Teacher"}};

    // default table model to modify the table
    private DefaultTableModel model = new DefaultTableModel(data, columns);

    // JTable
    private JTable table = new JTable(model);

    // four buttons for adding and deleting rows and columns
    private JButton jbtAddRow = new JButton("Add New Row");
    private JButton jbtAddColumn = new JButton("Add New Column");
    private JButton jbtDeleteRow = new JButton("Delete Selected Row");
    private JButton jbtDeleteColumn = new JButton("Delete Selected Column");

    // three buttons to save, clear and restore data 
    private JButton jbtSave = new JButton("Save");
    private JButton jbtClear = new JButton("Clear");
    private JButton jbtRestore = new JButton("Restore");

    public test() {

        // showing the grid and setting its color to black(default color is white)
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);

        // setting the title, size, location and default close operation for our JFrame
        setTitle("JTable Demo");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // using a panel with grid layout to group our four buttons
        JPanel p1 = new JPanel(new GridLayout(2, 2));
        p1.add(jbtAddRow);
        p1.add(jbtAddColumn);
        p1.add(jbtDeleteRow);
        p1.add(jbtDeleteColumn);

        // using a panel with defualt layout(flow layout) to group our three buttons
        JPanel p2 = new JPanel();
        p2.add(jbtSave);
        p2.add(jbtClear);
        p2.add(jbtRestore);

        // grouping our two panes inside of another panel
        JPanel p3 = new JPanel(new BorderLayout());
        p3.add(p2, BorderLayout.CENTER);
        p3.add(p1, BorderLayout.SOUTH);

        // adding the table to a scroll pane to make it scrollable(table is not scrollable by default)
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        // setting the selection mode to multiple interval(multiple items can be selected)
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // adding a new row
        jbtAddRow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // if the user selects a row we will add a new row before the selected row
                if (table.getSelectedRow() >= 0) {
                    model.insertRow(table.getSelectedRow(), new Vector<String>());
                } else {
                    // else the row will be added at the last index
                    model.addRow(new Vector<String>());
                }
            }
        });

        // adding a new column
        jbtAddColumn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // displaying a dialog to let the user enter the name for the column
                String name = JOptionPane.showInputDialog("Enter column name");
                // adding a column
                model.addColumn(name);
            }
        });

        // deleting a row
        jbtDeleteRow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // checking if the user has selected a row - if true delete the selected row
                if (table.getSelectedRow() >= 0) {
                    model.removeRow(table.getSelectedRow());
                }
            }
        });

        // deleting a column
        jbtDeleteColumn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // checking if the user has selected a column
                if (table.getSelectedColumn() >= 0) {
                    // getting the column model from the table
                    TableColumnModel columnModel = table.getColumnModel();
                    // getting the column from the column model
                    TableColumn column = columnModel.getColumn(table.getSelectedColumn());
                    // removing a column from the column model
                    columnModel.removeColumn(column);
                }
            }
        });

        // saving data
        jbtSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    // usins object output stream to save the data to a file
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("tabledata.dat"));
                    // saving row data
                    out.writeObject(model.getDataVector());
                    // saving column names
                    out.writeObject(getColumnNames());
                    out.close();
                } catch (Exception ex) {

                }
            }
        });

        // deleting data(we need to save the change after we press the clear button otherwise the deletion will not work)
        jbtClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // setting the row count to zero will erase all data
                model.setRowCount(0);
            }
        });

        // restoring data
        jbtRestore.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    // using object input stream to read the data back
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream("tabledata.dat"));
                    // using vectors to get the row and column names data
                    Vector<String> rowData = (Vector<String>) in.readObject();
                    Vector<String> columns = (Vector<String>) in.readObject();
                    // passing row and column names back to our model
                    model.setDataVector(rowData, columns);
                    in.close();
                } catch (Exception ex) {

                }
            }
        });

        setVisible(true);
    }

    // getting column names
    private Vector<String> getColumnNames() {

        Vector<String> columns = new Vector<String>();

        for (int i = 0; i < table.getColumnCount(); i++) {
            columns.add(table.getColumnName(i));
        }

        return columns;

    }

    public static void main(String[] args) {
        test m = new test();
    }
}
