const myslide = document.querySelectorAll('.myslider'),
        dot = document.querySelectorAll('.dot');
let counter = 1;
sildefun(counter);
let timer = setInterval(autoslide, 5000);
function autoslide(){
    counter++;
    sildefun(counter);
}
function plusSlider(n){
    counter += n;
    sildefun(counter);
    resetTimer();
}
function currentSlide(n){
    counter = n;
    sildefun(counter);
    resetTimer();
}
function resetTimer(){
    clearInterval(timer);
    timer = setInterval(autoslide, 8000);
}

function sildefun(n){
    let i ;
    for(i = 0; i <myslide.length;i++){
        myslide[i].style.display = "none";
    }
    for(i = 0; i <dot.length; i++){
        dot[i].classList.remove('active');
    }
    if(n < 1){
        counter = myslide.length;
    }
    if(n > myslide.length){
        counter = 1;
    }
    myslide[counter - 1].style.display = "block";
    dot[counter - 1].classList.add('active');
}

