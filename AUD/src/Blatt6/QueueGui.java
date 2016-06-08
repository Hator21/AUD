package Blatt6;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class QueueGui extends JFrame {

	private JPanel	contentPane;
	private JLabel	isEmptyLbl;
	private JLabel	lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueueGui frame = new QueueGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QueueGui() {
		setTitle("QueueGui");
		Queue<String> queue = new Queue<String>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JButton add = new JButton("Add Item");
		panel.add(add);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = JOptionPane.showInputDialog(null, "Item eingeben!");
				queue.offer(s);
				lblNewLabel.setText(queue.toString());
			}
		});

		JButton remove = new JButton("Remove Item");
		panel.add(remove);
		remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				queue.pop();
				lblNewLabel.setText(queue.toString());
			}
		});

		JButton show = new JButton("Show First");
		panel.add(show);
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				isEmptyLbl.setText(queue.peek());
				lblNewLabel.setText(queue.toString());
			}
		});

		JButton isEmpty = new JButton("is Empty?");
		panel.add(isEmpty);
		isEmpty.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				isEmptyLbl.setText("isEmpty? " + queue.isEmpty());
			}
		});

		JButton exit = new JButton("Exit");
		panel.add(exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);

			}
		});

		lblNewLabel = new JLabel("Useless GUI");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);

		isEmptyLbl = new JLabel("");
		isEmptyLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		isEmptyLbl.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(isEmptyLbl, BorderLayout.SOUTH);
	}

}
