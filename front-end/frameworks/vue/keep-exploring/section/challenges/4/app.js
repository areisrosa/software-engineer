new Vue({
	el: '#challenge',
	data: {
		class1: 'contrast',
		danger: true,
		class3: '',
		class4: '',
		color5: '',
		style5: {
			width: '100px',
			height: '100px',
		},
		width: '0',
	},
	methods: {
		startEffect() {
			setInterval(() => {
				this.class1 = this.class1 == 'contrast' 
					? 'select' : 'contrast'
			}, 5000)

		},
		startProgress() {
			let value = 0
			const time = setInterval(() => {
				value +=5
				this.width = `${value}%`
				if(value == 100) clearInterval(time)
			}, 500)
		},
		setDanger(event) {
			if(event.target.value == "true") {
				this.danger = true
			} else if(event.target.value == "false") {
				this.danger = false
			}
		}
	}
})
