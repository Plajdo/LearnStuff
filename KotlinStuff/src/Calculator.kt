import java.awt.BorderLayout
import java.awt.EventQueue
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

fun main(args : Array<String>){
	
	var x: Int = 15
	
	EventQueue.invokeLater(Runnable(){
		if(x in 1..10){
			println("heyyy")
			
		}else{
			println("not heyyy")
		}
		
		var instance: TableGUI = TableGUI()
		
	})
	
}

class TableGUI{
	constructor(){
		initialize()
		
	}
	
	fun initialize(){
		var frmExcelStuff: JFrame = JFrame()
		frmExcelStuff.setTitle("Kotlin stuff")
		frmExcelStuff.setBounds(100, 100, 450, 214)
		frmExcelStuff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
		frmExcelStuff.getContentPane().setLayout(BorderLayout())
		frmExcelStuff.setResizable(false)
		
		var label: JLabel = JLabel("Hello")
		frmExcelStuff.getContentPane().add(label, BorderLayout.CENTER)
		
		var button: JButton = JButton("CLICC MEH")
		button.addActionListener(ActionListener(){
			println("henlo guis")
			when(label.getText()){
				
				"Hello" -> label.setText("abcd blyat")
				else -> label.setText("Hello")
				
			}
			frmExcelStuff.setTitle("Totally excel stuff yes")
		})
		frmExcelStuff.getContentPane().add(button, BorderLayout.WEST)
		
		var button2: JButton = JButton("NOT CLICC MEH")
		button2.addActionListener(ActionListener(){
			label.setText("Helloo")
			println("text setting is fun yes")
		})
		frmExcelStuff.getContentPane().add(button2, BorderLayout.EAST)
		
		var textField: JTextField = JTextField("insert number blyat")
		textField.addActionListener(ActionListener(){
			try{
				label.setText((Integer.parseInt(textField.getText()) * 2).toString())
			}catch(e: NumberFormatException){
				textField.setText("yoo retardet, das not number blyat")
			}
			
		})
		frmExcelStuff.getContentPane().add(textField, BorderLayout.SOUTH)
		
		frmExcelStuff.setVisible(true)
			
	}
	
}