This file describes the basic algorithm used to get a list of similar doctors

Algorithm is based on the qualifications of doctors in the Doctor class:
speciality
reviewScore
yearsOfExperience
education

The algorithm is executed in the FindDoctors class in the getSimilarDoctors method.
-> Initially the doctors with similar speciality are seperated since they are the most relevant

-> Then the doctors with same speciality are priortized based on years of experience, review score and education. Order being years of experience > review > education. I have selected the criteria for priority based on what I think will be most relevant to the user. Ofcourse it requires discussion with the project manager.

-> Finally the remaining doctors are added to the list and the list is returned.

I have also indicated some qualifications in the doctors class which can be used for future for improving the priority algorithm