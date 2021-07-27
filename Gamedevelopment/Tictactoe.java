package Gamedevelopment;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tictactoe extends JFrame implements ActionListener{
//tic tac toe is of 3*3 matrix
public static int Board_size=3;
//for checking what is the status of the game
public static  enum Gamestatus
{
Incomplete,Xwins,Zwins,Tie
}
//jbutton represents the matrix
private JButton[][]buttons=new JButton[Board_size][Board_size];
//first turn to click is of cross
boolean crossTurn=true;
public Tictactoe(){
//it will set title to tic tac toe
super.setTitle("Tic Tac Toe");
super.setSize(800,800);
GridLayout grid=new GridLayout(Board_size,Board_size);//for making the grid of 3 cross 3 matrix
super.setLayout(grid);//setting layout
super.setResizable(false);//not allowing the screen to resize
Font font=new Font("Comic Sans",1,150);
for(int r=0;r<Board_size;r++) {//for creating grid of button
for(int c=0;c<Board_size;c++)
{
JButton button=new JButton("");//intialise button
buttons[r][c]=button;//setting in matrix
button.setFont(font);
button.addActionListener(this);
super.add(button);
}
}
super.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
JButton clickedbutton=(JButton)e.getSource();//would get the source from where it has been called
makeMove(clickedbutton);
Gamestatus gs=this.getgamestatus();
if(gs==Gamestatus.Incomplete)
{
return;
}
declarewinner(gs);
//for making user friendly
int check=JOptionPane.showConfirmDialog(this, "Do you want to play again?");
if(check==JOptionPane.YES_OPTION)
{
for(int r=0;r<Board_size;r++) {//for creating grid of button
for(int c=0;c<Board_size;c++)
{
//intialise button to empty
buttons[r][c].setText("");
}
}
crossTurn=true;//it is for setting first turn of X
}
else
{
super.dispose();
}
}
private void declarewinner(Gamestatus gs) {
// TODO Auto-generated method stub
if(gs==Gamestatus.Xwins)
JOptionPane.showMessageDialog(this, "Xwins");
else if(gs==Gamestatus.Zwins)
JOptionPane.showMessageDialog(this, "Zwins");
else
JOptionPane.showMessageDialog(this, "Tie");

}
private Gamestatus getgamestatus() {
String text1="",text2="";
int row=0,col=0;
//text inside row
while(row<Board_size)
{
col=0;
while(col<Board_size-1)
{
text1=buttons[row][col].getText();
text2=buttons[row][col+1].getText();
if(!text1.equals(text2)||text1.length()==0)
{
break;
}
col++;
}
if(col==Board_size-1)//it will  happen only if all the element till size-1 are same
{
if(text1.equals("X"))
return Gamestatus.Xwins;
else
return Gamestatus.Zwins;
}
row++;
}
//text inside column
col=0;
while(col<Board_size)
{
row=0;
while(row<Board_size-1)
{
text1=buttons[row][col].getText();
text2=buttons[row+1][col].getText();
if(!text1.equals(text2)||text1.length()==0)
{
break;
}
row++;
}
if(row==Board_size-1)//it will  happen only if all the element till size-1 are same
{
if(text1.equals("X"))
return Gamestatus.Xwins;
else
return Gamestatus.Zwins;
}
col++;
}
//text inside diagonal
row=0;
col=0;
while(row<Board_size-1)
{
text1=buttons[row][col].getText();
text2=buttons[row+1][col+1].getText();
if(!text1.equals(text2)||text1.length()==0)
{
break;
}
row++;
col++;
}
if(row==Board_size-1)
{
if(text1.equals("X"))
return Gamestatus.Xwins;
else
return Gamestatus.Zwins;
}
//for second diagonal
row=0;
col=Board_size-1;
while(row<Board_size-1)
{
text1=buttons[row][col].getText();
text2=buttons[row+1][col-1].getText();
if(!text1.equals(text2)||text1.length()==0)
{
break;
}
row++;
col--;
}
if(row==Board_size-1)
{
if(text1.equals("X"))
return Gamestatus.Xwins;
else
return Gamestatus.Zwins;
}
///if still noone wins
String txt="";
for(int r=0;r<Board_size;r++)
{
for(int c=0;c<Board_size;c++)
{
txt=buttons[r][c].getText();
if(txt.length()==0)
{
return Gamestatus.Incomplete;
}
}
}
//means it is full means tied
return Gamestatus.Tie;
}
private void makeMove(JButton clickedbutton) {
// TODO Auto-generated method stub
String btntext=clickedbutton.getText();
if(btntext.length()>0)//if there is X or O written previously then
{
JOptionPane.showMessageDialog(this, "Invalid Move");
}
else
{
if(crossTurn)
clickedbutton.setText("X");
else
clickedbutton.setText("O");
crossTurn=!crossTurn;
}

}
}


