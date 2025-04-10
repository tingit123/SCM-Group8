package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
	private JTextField txtSo1, txtSo2, txtKetQua;

	public Calculator() {
		setTitle("Máy tính cộng trừ nhân chia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLayout(null);

		JLabel lbl1 = new JLabel("Số 1:");
		lbl1.setBounds(30, 30, 50, 25);
		add(lbl1);

		txtSo1 = new JTextField();
		txtSo1.setBounds(90, 30, 150, 25);
		add(txtSo1);

		JLabel lbl2 = new JLabel("Số 2:");
		lbl2.setBounds(30, 70, 50, 25);
		add(lbl2);

		txtSo2 = new JTextField();
		txtSo2.setBounds(90, 70, 150, 25);
		add(txtSo2);

		JButton btnCong = new JButton("Cộng");
		btnCong.setBounds(30, 120, 90, 30);
		add(btnCong);

		JButton btnTru = new JButton("Trừ");
		btnTru.setBounds(130, 120, 90, 30);
		add(btnTru);

		JButton btnNhan = new JButton("Nhân");
		btnNhan.setBounds(230, 120, 90, 30);
		add(btnNhan);

		JButton btnChia = new JButton("Chia");
		btnChia.setBounds(330, 120, 90, 30);
		add(btnChia);

		JLabel lblKetQua = new JLabel("Kết quả:");
		lblKetQua.setBounds(30, 180, 100, 25);
		add(lblKetQua);

		txtKetQua = new JTextField();
		txtKetQua.setBounds(90, 180, 330, 30);
		txtKetQua.setEditable(false);
		add(txtKetQua);

		// Xử lý nút
		btnCong.addActionListener(e -> tinhToan("cong"));
		btnTru.addActionListener(e -> tinhToan("tru"));
		btnNhan.addActionListener(e -> tinhToan("nhan"));
		btnChia.addActionListener(e -> tinhToan("chia"));
	}

	private void tinhToan(String phepTinh) {
		try {
			double a = Double.parseDouble(txtSo1.getText());
			double b = Double.parseDouble(txtSo2.getText());
			String ketQua = "";

			switch (phepTinh) {
				case "cong":
					ketQua = String.valueOf(Cong.tinh(a, b));
					break;
				case "tru":
					ketQua = String.valueOf(Tru.tinh(a, b));
					break;
				case "nhan":
					ketQua = String.valueOf(Nhan.tinh(a, b));
					break;
				case "chia":
					ketQua = Chia.tinh(a, b); // Trả về String vì có thể báo lỗi chia 0
					break;
			}
			txtKetQua.setText(ketQua);
		} catch (NumberFormatException e) {
			txtKetQua.setText("Vui lòng nhập số hợp lệ");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Calculator frame = new Calculator();
			frame.setVisible(true);
		});
	}
}