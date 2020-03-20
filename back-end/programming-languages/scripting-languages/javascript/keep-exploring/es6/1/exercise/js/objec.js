let freed = {name: 'Jose', 
    sexo: 'M',
    peso: 85, 
    fatten(p){
        console.log('Fatten')
        this.peso += p
    }}
freed.fatten(2)
console.log(`${freed.name} pesa ${freed.peso}Kg`)
