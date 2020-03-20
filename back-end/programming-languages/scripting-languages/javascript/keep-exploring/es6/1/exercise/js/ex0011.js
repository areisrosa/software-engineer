
var years = 22

console.log(`You are ${years} old.`)

if(years < 16) {
    console.log('Don not vote')
} else if (years < 18 || years > 65) {
    console.log('Vote optional')
} else {
    console.log('Vote required')
}
