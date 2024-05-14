import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  // Size of window
  public void settings() {
    
    size(800, 800);
  }

  // White background
  public void setup() {
    
    background(255, 255, 255);
  }

  // Draws a cloud whenever a key is pressed and expands the cloud based on the arrow keys
  // Declare the initial values for cloud x and cloud y
  float fltCloudX = 0;
  float fltCloudY = 0;

  // Boolean variables for the arrow keys
  boolean boolUp = false;
  boolean boolDown = false;
  boolean boolLeft = false;
  boolean boolRight = false;

  public void draw() {

    // Arrow keys move the cloud in different directions
    if (boolUp) {
        
      fltCloudY -= 2;
    }
    if (boolDown) {
        
      fltCloudY += 2;
    }
    if(boolLeft){
        
      fltCloudX -= 2;
    }
    if(boolRight){
        
       fltCloudX += 2;
     }

     // Draws the white cloud in the top left corner
     colorMode(RGB, 255);
     fill(255, 255, 255);
     noStroke();
     ellipse(fltCloudX + width * 50/400, fltCloudY + height * 50/400, width * 50/400, height * 50/400);
     ellipse(fltCloudX + width * 75/400, fltCloudY + height * 60/400, width * 50/400, height * 50/400);
     ellipse(fltCloudX + width * 85/400, fltCloudY + height * 45/400, width * 50/400, height * 50/400);
     ellipse(fltCloudX + width * 100/400, fltCloudY + height * 64/400, width * 50/400, height * 50/400);
 }
  
  // KeyPressed function to set the boolean variables of the arrow keys to true
  public void keyPressed() {

    if (keyCode == UP) {
      
      boolUp = true;
    }
    if (keyCode == DOWN) {
      
      boolDown = true;
    }
    if (keyCode == LEFT) {
      
      boolLeft = true;
    }
    if (keyCode == RIGHT) {
      
      boolRight = true;
    }
  }

  // KeyReleased function to set the boolean variable of the arrow keys to false
  public void keyReleased() {
    
    if (keyCode == UP) {
      
      boolUp = false;
    }
    if (keyCode == DOWN) {
      
      boolDown = false;
    }
    if (keyCode == LEFT) {
      
      boolLeft = false;
    }
    if (keyCode == RIGHT) {
      
      boolRight = false;
    }
  }

  // Changes the saturation of the background colour when the mouse wheel is scrolled
  // Variable that declares the original saturation of 0
  float fltSaturation = 0;

  public void mouseWheel() {

    // Changes the colour mode so the saturation can be adjusted and draws the background
    colorMode(HSB, 360, 100, 100);
    background(180, fltSaturation, 100);

    // Increases the saturation as long as it is below 100
    if (fltSaturation < 100) {
      
      fltSaturation += 2;
    }
    
    // Resets the saturation value when it is 100 or above
    else {
      fltSaturation = 0;
    }
  }

  // Draws a face when the mouse is pressed
  public void mousePressed() {
    
    // Sets the colour mode to RGB and the face size to be 75
    colorMode(RGB, 255);
    float fltSize = 75;

    // Variables for eye distance and size
    float fltEyeDist = fltSize / 3;
    float fltEyeSize = fltSize / 10;

    // Variable for mouth size
    float fltMouthSize = fltSize / 4;
    
    // Head
    noStroke();
    fill(255, 255, 255);
    ellipse(mouseX, mouseY, fltSize, fltSize);
    
    // Left and right eye
    fill(0, 0, 0);
    ellipse(mouseX - fltEyeDist, mouseY, fltEyeSize, fltEyeSize);
    ellipse(mouseX + fltEyeDist, mouseY, fltEyeSize, fltEyeSize);

    // Mouth
    fill(237, 133, 133);
    arc(mouseX, mouseY, fltMouthSize, fltMouthSize, 0, radians(180), CHORD);
    
  }

  // Draws grass when the mouse is dragged
  public void mouseDragged() {
    
    // Sets the colour mode to RGB
    colorMode(RGB, 255);

    // Grass paintbrush
    noStroke();
    fill(122, 255, 138);
    ellipse(mouseX, mouseY, width / 8, height / 8);

  }

  // Draws a pink or orange flower when the mouse is clicked
  public void mouseClicked() {
    
    // Sets the colour mode to RGB
    colorMode(RGB, 255);

    // Variables that set the size of each flower to be random and calculates the distance of the petals from the centre
    float fltFlowerSize = random(height * 1/15, height * 1/10);
    float fltFlowerDist = fltFlowerSize * 5/12;

    // Variables that sets the RGB values of the flower petals to be pink
    float fltRed = 250;
    float fltGreen = 180;
    float fltBlue = 180;

    // Changes the RGB values of the petals when certain keys are pressed
    if (keyPressed) {
      
      // Changes the RBB values to orange
      if (key == 'o') {
        
        fltRed = 255;
        fltGreen = 177;
        fltBlue = 99;
      }

      // Changes the RGB values to red
      if (key == 'r') {

        fltRed = 255;
        fltGreen = 95;
        fltBlue = 87;
      }
    }

    // Draws the flower petals
    noStroke();
    fill(fltRed, fltGreen, fltBlue);
    ellipse(mouseX - fltFlowerDist, mouseY - fltFlowerDist, fltFlowerSize, fltFlowerSize);
    ellipse(mouseX + fltFlowerDist, mouseY - fltFlowerDist, fltFlowerSize, fltFlowerSize);
    ellipse(mouseX - fltFlowerDist, mouseY + fltFlowerDist, fltFlowerSize, fltFlowerSize);
    ellipse(mouseX + fltFlowerDist, mouseY + fltFlowerDist, fltFlowerSize, fltFlowerSize);
    
    // Draws the flower centre
    fill(240, 231, 163);
    stroke(240, 231, 163);
    ellipse(mouseX, mouseY, fltFlowerSize, fltFlowerSize);
  }  
}