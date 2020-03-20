function change() {
    var msg = window.document.getElementById('msg')
    var img = window.document.getElementById('imagem')
    var date = new Date()
    var hours = date.getHours()
    // var hours = 22
    msg.innerHTML = `Here will ${hours} hours.`
    if(hours >= 0 && hours < 12) {
        img.src = 'pexels1.jpeg'
    } else if (hours >= 12 && hours <= 18) {
        img.src = 'pexels2.jpeg'
    } else {
        img.src = 'pexels3.jpeg'
    }
}
