/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author manoj
 */
public class first 
{
    private static BufferedImage image;
    
     private static final int IMG_WIDTH = 150;
	private static final int IMG_HEIGHT = 150;
    
    private static BufferedImage resizeImage(BufferedImage originalImage, int type){
	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	g.dispose();
 
	return resizedImage;
    }
    
public static void main(String[] args) throws IOException 
{
int n;
Scanner in=new Scanner(System.in);    
System.out.println("Enter number of SKUs to compare");
n=in.nextInt();
System.out.println("Enter Folder location (e.x) C:\\\\Users\\\\mukunthan.g2\\\\Desktop\\\\New folder\\\\");
//System.out.println("(e.x) C:\\Users\\mukunthan.g2\\Desktop\\New folder\\");
String fi=in.next();

Scanner s = new Scanner(new File(fi.concat("1.txt")));
Scanner s1 = new Scanner(new File(fi.concat("2.txt")));
Scanner sku = new Scanner(new File(fi.concat("3.txt")));
File file = new File(fi.concat("output.txt")); 
PrintWriter output = new PrintWriter(file); 
ArrayList<String> list = new ArrayList<String>();
ArrayList<String> out1 = new ArrayList<String>();
while (s.hasNext()){
    list.add(s.next());
}
s.close();
ArrayList<String> list1 = new ArrayList<String>();
while (s1.hasNext()){
list1.add(s1.next());
}
s.close();  

ArrayList<String> skus = new ArrayList<String>();
while (sku.hasNext()){
skus.add(sku.next());
}
s.close();






int k=0;



for (int j=0;j<n;j++)    
{
String fu=list1.get(j);
String su=list.get(j);
try{
URL url = new URL(fu); 
image = ImageIO.read(url);
ImageIO.write(image, "jpg",new File(fi.concat(("1.jpg"))));
}
catch (Exception e1)
    {
BufferedImage originalImage = ImageIO.read(new File(fi.concat(("bk.jpg"))));
int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_RGB : originalImage.getType();
BufferedImage resizeImageJpg = resizeImage(originalImage, type);
ImageIO.write(resizeImageJpg, "jpg", new File(fi.concat("1.jpg")));
    }
try{
URL url1 = new URL(su); 
image = ImageIO.read(url1);
ImageIO.write(image, "jpg",new File(fi.concat("2.jpg")));
}
catch (Exception e2)
    {
    BufferedImage originalImage = ImageIO.read(new File(fi.concat("wt.jpg")));
int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_RGB : originalImage.getType();
BufferedImage resizeImageJpg = resizeImage(originalImage, type);
ImageIO.write(resizeImageJpg, "jpg", new File(fi.concat("5.jpg")));
    }

for(int i=1;i<=2;i++)
{
if(i==1)
{
    
 try{
BufferedImage originalImage = ImageIO.read(new File(fi.concat("1.jpg")));
int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_RGB : originalImage.getType();

BufferedImage resizeImageJpg = resizeImage(originalImage, type);
ImageIO.write(resizeImageJpg, "jpg", new File(fi.concat("4.jpg"))); 
 }
 catch (Exception e)
    {
    BufferedImage originalImage = ImageIO.read(new File(fi.concat(fi.concat("bk.jpg"))));
int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_RGB : originalImage.getType();
BufferedImage resizeImageJpg = resizeImage(originalImage, type);
ImageIO.write(resizeImageJpg, "jpg", new File(fi.concat("4.jpg")));
    }
 
}
if(i==2)
{
    try{
BufferedImage originalImage = ImageIO.read(new File(fi.concat("2.jpg")));
int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_RGB : originalImage.getType();
BufferedImage resizeImageJpg = resizeImage(originalImage, type);
ImageIO.write(resizeImageJpg, "jpg", new File(fi.concat("5.jpg"))); 
    }
    catch (Exception e)
    {
    BufferedImage originalImage = ImageIO.read(new File(fi.concat("wt.jpg")));
int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_RGB : originalImage.getType();
BufferedImage resizeImageJpg = resizeImage(originalImage, type);
ImageIO.write(resizeImageJpg, "jpg", new File(fi.concat("5.jpg")));
    }
}
}

//color
BufferedImage biA= ImageIO.read(new File(fi.concat("4.jpg")));
DataBuffer dbA = biA.getData().getDataBuffer();
int sizeA = dbA.getSize();   

//color
BufferedImage biB= ImageIO.read(new File(fi.concat("5.jpg")));
DataBuffer dbB = biB.getData().getDataBuffer();

//CreateBWImageNoJAIRender bwimg= new CreateBWImageNoJAIRender();



int sizeB = dbB.getSize();
int[] a=new int[16875];
int[] b=new int[16875];
int[] c=new int[16875];
int[] d=new int[16875];
int[] w=new int[16875];
int[] x=new int[16875];
int[] y=new int[16875];
int[] z=new int[16875];




int lo=0;
  

for(int i=0; i<16875; i++) 
{ 
a[lo]=dbA.getElem(i); w[lo]=dbB.getElem(i); 
lo++;
}
lo=0;
for(int i=16875; i<(16874*2); i++) 
{
b[lo]=dbA.getElem(i); x[lo]=dbB.getElem(i); 
lo++;
}
lo=0;
for(int i=(16874*2); i<(16874*3); i++) 
{ 
c[lo]=dbA.getElem(i); y[lo]=dbB.getElem(i);    
lo++;
}
lo=0;
for(int i=(16874*3); i<(16874*4); i++) 
{ 
d[lo]=dbA.getElem(i); z[lo]=dbB.getElem(i);   
lo++;
}

float a1=0,b1=0,c1=0,d1=0,w1=0,x1=0,y1=0,z1=0; 

for(int i=0; i<16875; i++)
{
a1=a[i]+a1; w1=w[i]+w1;
}

for(int i=0; i<16875; i++)
{ 
b1=b[i]+b1; x1=x[i]+x1;
}
for(int i=0; i<16875; i++)
{
c1=c[i]+c1; y1=y[i]+y1;
}
for(int i=0; i<16875; i++)
{
d1=d[i]+d1; z1=z[i]+z1;
}

float fst=(a1-w1);
float snd=(b1-x1);
float thd=(c1-y1);
float fth=(d1-z1);

if(fst<0) fst=fst*(-1);
if(snd<0) snd=snd*(-1);
if(thd<0) thd=thd*(-1);
if(fth<0) fth=fth*(-1);

float fst1=(w1-a1);
float snd1=(x1-b1);
float thd1=(y1-c1);
float fth1=(z1-d1);

if(fst1<0) fst1=fst1*(-1);
if(snd1<0) snd1=snd1*(-1);
if(thd1<0) thd1=thd1*(-1);
if(fth1<0) fth1=fth1*(-1);

float oo1=((fst1/a1)*100);
float oo2=((snd1/b1)*100); 
float oo3=((thd1/c1)*100); 
float oo4=((fth1/d1)*100); 


 float o1=((fst/a1)*100);
 float o2=((snd/b1)*100); 
 float o3=((thd/c1)*100); 
 float o4=((fth/d1)*100); 
String opt=new String("correct");
String opt1=new String("incorrect");
 
 String result=null;
if (o1<15 && o2<15 && o3<15 && o4<15 ) 
{  
if (oo1<15 && oo2<15 && oo3<15 && oo4<15 ) 
{    
result=opt;                 
System.out.println(opt+" "+o1+" "+o2+" "+o3+" "+o4);
}
}
if (o1>15 || o2>15 || o3>15 || o4>15) 
{
if (oo1>15 || oo2>15 || oo3>15 || oo4>15) 
{ 
result=opt1;                 
System.out.println(opt1+" "+o1+" "+o2+" "+o3+" "+o4);
}
}  
output.println(skus.get(j)+" " +result+" "+o1+" "+o2+" "+o3+" "+o4); 
out1.add(result);
k++;

 }
 output.close();
}
/*catch(Exception e)
{
System.out.println("error at  "+(k+1) + " url");
output.close(); 
for (int i=0;i<out1.size();i++)
{
 output.println(skus.get(i)+" "+out1.get(i));    
}
}*/
    
}




  
