let quote=document.getElementById('quote');
let author=document.getElementById('author');

function displayTimer(){

var countdownElement = document.getElementById('countdown');

var count = 10;
countdownElement.innerText = count;


var countdown = setInterval(function() {
  count--;
  countdownElement.innerText = count;

  if (count === 0) {
    clearInterval(countdown);
  
  }
}, 1000);

}

async function getQuote(){
    
    let quoteData="quote";
    
    displayTimer();
    
    quoteData=await axios.get("http://localhost:8080/quote/get");
    
    console.log(quoteData.data);

	quote.innerText="\""+quoteData.data.q+"\"";
	author.innerText=quoteData.data.a;
	
	
}

let message=setInterval(()=>{getQuote();},10000);