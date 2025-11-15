import java.awt.BorderLayout
import java.awt.Color
import java.awt.Desktop
import java.awt.EventQueue
import java.awt.FlowLayout
import java.awt.GridBagLayout
import java.net.URI
import javax.swing.JButton
import javax.swing.JCheckBox
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

class CreatePage : JFrame() {
    init {
        setSize(300, 500)
        isVisible = true
    }
}

class  HomeScreen : JFrame() {

    init {
        setSize(300, 600)
        isResizable = false
        contentPane.layout = FlowLayout()
        contentPane.background = Color(10, 10, 10)
        val button = JButton("Submit")
        val label = JLabel()
        val nameTitle = JLabel("YouTubeChannelOpenerURL")

        val f = JTextField(20)

        button.addActionListener {

            if (f.getText().contains("Admin")) {


                contentPane.background = Color(21 , 71, 52)
                label.foreground = Color(255, 255, 255)
                println("Hello World")
                label.text = "| Welcome Admin |"
                label.font = font.deriveFont(18)
                nameTitle.isVisible = false

                val win = CreatePage()
                contentPane.isVisible = true
                isVisible = false
                win.layout = GridBagLayout()
                add(nameTitle, BorderLayout.SOUTH)

                val checkBoxOne = JCheckBox("XpertThief")
                win.add(checkBoxOne)
                checkBoxOne.addActionListener {

                    val url = URI("www.youtube.com/XpertThief")
                    Desktop.getDesktop().browse(URI.create(url.toString()) as URI)

                }


                val checkBoxTwo = JCheckBox("iCrazyTeddy")
                win.add(checkBoxTwo)

                contentPane.background = Color(255, 255, 255)

                checkBoxTwo.addActionListener {
                    val url = URI("www.youtube.com/iCrazyTeddy")
                    Desktop.getDesktop().browse(URI.create(url.toString()) as URI)
                }

                win.isResizable = false
            }
        }

        add(nameTitle, BorderLayout.SOUTH)
        add(label, BorderLayout.SOUTH)
        add(f, BorderLayout.SOUTH)
        add(button, BorderLayout.SOUTH)
    }
}

private fun createWindow() {
    val home = HomeScreen()

    if (home.isEnabled) {
        home.isVisible = true
    }
}

fun main() {
    EventQueue.invokeLater(::createWindow)
}