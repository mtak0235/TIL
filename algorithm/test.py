class Animal:
    def __init__(self, 종, age, name):
        self.species = 종
        self.age = age
        self.name = name

    def eat(self):
        print(self.name+ "이(가) 먹이를 먹습니다.")

    def move(self):
        print(f"{self.name}이(가) 움직입니다.")

    def make_sound(self):
        print(f"{self.name}이(가) 소리를 냅니다.")
    
dog = Animal("개", 3, "멍멍이")
cat = Animal("고양이", 2, "야옹이")

dog.eat()