package io.github.plajdo.learnstuff.lanterna

import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.gui2.*
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import java.util.regex.Pattern

fun main(args: Array<String>) {
	var terminal = DefaultTerminalFactory().createTerminal()
	var screen = TerminalScreen(terminal)
	screen.startScreen()
	
	var panel = Panel()
	panel.layoutManager = GridLayout(2)
	
	var numABox = TextBox().setValidationPattern(Pattern.compile("-?[0-9]*"))
	var numBBox = TextBox().setValidationPattern(Pattern.compile("-?[0-9]*"))
	
	panel.addComponent(Label("Num 1:"))
	panel.addComponent(numABox)
	
	panel.addComponent(Label("Num 2:"))
	panel.addComponent(numBBox)
	
	panel.addComponent(Label("Operation:"))
	
	var operations = ComboBox<String>()
	operations.addItem("Add")
	operations.addItem("Subtract")
	operations.addItem("Multiply")
	operations.addItem("Divide")
	
	var labelOutput = Label("")
	
	panel.addComponent(operations)
	
	panel.addComponent(EmptySpace(TerminalSize(0, 0)))
	panel.addComponent(Button("Calculate", {calculate(Integer.parseInt(numABox.text), Integer.parseInt(numBBox.text), operations, labelOutput)}))
	
	panel.addComponent(EmptySpace(TerminalSize(0, 0)))
	panel.addComponent(labelOutput)
	
	var window = BasicWindow()
	window.component = panel
	
	var gui = MultiWindowTextGUI(screen, DefaultWindowManager(), EmptySpace(TextColor.ANSI.BLACK))
	gui.addWindowAndWait(window)
	
}

fun calculate(num1 : Int, num2 : Int, operation : ComboBox<String>, output : Label){
	when(operation.selectedIndex){
		
		0 -> output.text = (num1 + num2).toString()
		1 -> output.text = (num1 - num2).toString()
		2 -> output.text = (num1 * num2).toString()
		3 -> if(num2 != 0) output.text = (num1.toFloat() / num2.toFloat()).toString() else output.text = "/ by 0"
		
	}
	
}