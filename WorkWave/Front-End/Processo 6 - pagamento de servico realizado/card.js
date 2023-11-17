let tColorA = document.getElementById('tColorA'),
tColorB = document.getElementById('tColorB'),
iconA = document.querySelector('.fa-credit-card'),
iconB = document.querySelector('.fa-building-columns'),
cDetails = document.querySelector('.card-details');
pDetails= document.querySelector('.pix-details')
pDetails.style.display = "none";

function doFun(){
 tColorA.style.color = "#1DC1A4";
 tColorB.style.color = "#444";
 iconA.style.color = "#1DC1A4";
 iconB.style.color = "#aaa";
 cDetails.style.display = "block";
 pDetails.style.display = "none";
}
function doFunA(){
 tColorA.style.color = "#444";
 tColorB.style.color = "#1DC1A4";
 iconA.style.color = "#aaa";
 iconB.style.color = "#1DC1A4";
 cDetails.style.display = "none";
 pDetails.style.display = "block";
}
let cNumber = document.getElementById('number');
cNumber.addEventListener('keyup', function(e){
 let num = cNumber.value;

 let newValue = '';
 num = num.replace(/\s/g, '');
 for(var i = 0; i < num.length; i++) {
  if(i%4 == 0 && i > 0) newValue = newValue.concat(' ');
  newValue = newValue.concat(num[i]);
  cNumber.value = newValue;
 }

 let ccNum = document.getElementById('c-number');
 if(num.length<16){
  ccNum.style.border="1px solid red";
 }else{
  ccNum.style.border="1px solid greenyellow";
 }
});

let eDate = document.getElementById('e-date');
eDate.addEventListener('keyup', function( e ){

 let newInput = eDate.value;

 if(e.which !== 8) {
  var numChars = e.target.value.length;
  if(numChars == 2){
   var thisVal = e.target.value;
   thisVal += '/';
   e.target.value = thisVal;
   console.log(thisVal.length)
  }
 }

 if(newInput.length<5){
  eDate.style.border="1px solid red";
 }else{
  eDate.style.border="1px solid greenyellow";
 }
});

let cvv = document.getElementById('cvv');
cvv.addEventListener('keyup', function(e){

 let elen = cvv.value;
 let cvvBox = document.getElementById('cvv-box');
 if(elen.length<3){
  cvvBox.style.border="1px solid red";
 }else{
  cvvBox.style.border="1px solid greenyellow";
 }
})
