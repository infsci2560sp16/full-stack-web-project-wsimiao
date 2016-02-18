var myImage=document.getElementById(slideshow);
var imageArray=["images/slide1.jpg","images/slide2.jpg","images/1.jpg"];
var imageIndex=0;
function changeImage(){
  slideshow.setAttribute("src",imageArray[imageIndex]);
  imageIndex++;
  if(imageIndex >= imageArray.length){
    imageIndex=0;
  }
}

var intervalHandle = setInterval(changeImage,2000);
slideshow.onclick=function(){
  clearInterval(intervalHandle);
}
