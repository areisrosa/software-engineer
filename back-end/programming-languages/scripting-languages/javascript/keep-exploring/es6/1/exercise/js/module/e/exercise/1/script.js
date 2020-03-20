function counter() {

    let start = document.getElementById('txts')
    let theEnd = document.getElementById('txte')
    let step = document.getElementById('txtp')
    let res = document.getElementById('res')
    if (start.value.length == 0 || theEnd.value.length == 0 || step.value.length == 0) {
        res.innerHTML = 'Impossible to count'
    }
    else {
        res.innerHTML = 'Counting: <br> '
        let s = Number(start.value)
        let e = Number(theEnd.value)
        let p = Number(step.value)
        if (p <= 0) {
            window.alert('Invalid step! Consider the step 1')
            p = 1
        }
        if (s < e) {
            // rising count
            for(let c = s; c <= e; c += p) {
                res.innerHTML += ` ${c} \u{1F449}`
            }
        }
        else {
            // countdown
            for(let c = s; c >= e; c -= p)
                res.innerHTML += ` ${c} \u{1F449}`
        }
        res.innerHTML += `\u{1F3C1}`
    }
}
