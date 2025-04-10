package main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HSSVFrame extends JFrame {

    private JTextField txtMSSV, txtHoTen, txtEmail, txtPhone;
    private JComboBox<String> comboGioiTinh;
    private JSpinner spinnerNgaySinh;
    private JTable table;
    private DefaultTableModel tableModel;

    public HSSVFrame() {
        initComponents();
    }

    private void initComponents() {
        
        setTitle("Quản lý hồ sơ sinh viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

      
        JPanel panelInput = new JPanel(new GridLayout(6, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

       
        JLabel lblMSSV = new JLabel("MSSV:");
        txtMSSV = new JTextField();
        panelInput.add(lblMSSV);
        panelInput.add(txtMSSV);

        
        JLabel lblHoTen = new JLabel("Họ và tên:");
        txtHoTen = new JTextField();
        panelInput.add(lblHoTen);
        panelInput.add(txtHoTen);

    
        JLabel lblNgaySinh = new JLabel("Ngày sinh:");
        spinnerNgaySinh = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerNgaySinh, "dd/MM/yyyy");
        spinnerNgaySinh.setEditor(dateEditor);
        panelInput.add(lblNgaySinh);
        panelInput.add(spinnerNgaySinh);

      
        JLabel lblGioiTinh = new JLabel("Giới tính:");
        comboGioiTinh = new JComboBox<>();
        comboGioiTinh.addItem("Nam");
        comboGioiTinh.addItem("Nữ");
        panelInput.add(lblGioiTinh);
        panelInput.add(comboGioiTinh);

 
        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        panelInput.add(lblEmail);
        panelInput.add(txtEmail);

      
        JLabel lblPhone = new JLabel("Phone:");
        txtPhone = new JTextField();
        panelInput.add(lblPhone);
        panelInput.add(txtPhone);

        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAdd = new JButton("Thêm mới");
        JButton btnDelete = new JButton("Xóa");
        JButton btnClose = new JButton("Đóng");
        panelButtons.add(btnAdd);
        panelButtons.add(btnDelete);
        panelButtons.add(btnClose);

       
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.add(panelInput, BorderLayout.CENTER);
        panelTop.add(panelButtons, BorderLayout.SOUTH);

       
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"MSSV", "Họ và tên", "Ngày sinh", "Giới tính", "Email", "Phone"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        
        add(panelTop, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

       
        btnAdd.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        
        btnDelete.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

       
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

  
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    txtMSSV.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    txtHoTen.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    try {
                        Date date = new SimpleDateFormat("dd/MM/yyyy")
                                .parse(tableModel.getValueAt(selectedRow, 2).toString());
                        spinnerNgaySinh.setValue(date);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    comboGioiTinh.setSelectedItem(tableModel.getValueAt(selectedRow, 3).toString());
                    txtEmail.setText(tableModel.getValueAt(selectedRow, 4).toString());
                    txtPhone.setText(tableModel.getValueAt(selectedRow, 5).toString());
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

   
    private void addStudent() {
        String mssv = txtMSSV.getText().trim();
        String hoTen = txtHoTen.getText().trim();
        Date ngaySinhDate = (Date) spinnerNgaySinh.getValue();
        String ngaySinh = new SimpleDateFormat("dd/MM/yyyy").format(ngaySinhDate);
        String gioiTinh = comboGioiTinh.getSelectedItem().toString();
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();

        if (mssv.isEmpty() || hoTen.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Vui lòng nhập đầy đủ MSSV và Họ tên!",
                    "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{mssv, hoTen, ngaySinh, gioiTinh, email, phone});
        JOptionPane.showMessageDialog(this,
                "Thêm mới thành công!",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        clearFields();
    }

    
    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this,
                    "Xóa thành công!",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Vui lòng chọn một dòng để xóa!",
                    "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    
    private void clearFields() {
        txtMSSV.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        spinnerNgaySinh.setValue(new Date());
        comboGioiTinh.setSelectedIndex(0);
    }

   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HSSVFrame().setVisible(true);
            }
        });
    }
}