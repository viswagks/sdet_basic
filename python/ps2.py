class Student:
    def __init__(self, name, grade, age):
        self.name = name
        self.grade = grade
        self.age = age

    def display(self):
        print("Student " + self.name + " in grade " + str(self.grade) + " is of age " + str(self.age))


class School(Student):
    def __init__(self, name, grade, age):
        Student.__init__(self, name, grade, age)

    def schoolstudentdisplay(self):
        print("Student " + self.name + " in grade " + str(self.grade) + " is of age " + str(self.age))


student = Student("Leo Messi", 5, 10)
school = School("John Cena", 8, 13)
student.display()
school.schoolstudentdisplay()