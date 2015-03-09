library(kernlab)
library(caret)
misuse<-read.csv("file:///C:/Users/Saunil/Desktop/ISS/Project/Dataset_Misuse.csv", na.strings=c(".", "NA", "", "?"), strip.white=TRUE, encoding="UTF-8")
mRow<-nrow(misuse)
mCol<-ncol(misuse)

sub<-sample(1:mRow,floor(0.66*mRow))
misuseTrainingSet<- misuse[sub,]
misuseTestSet<- misuse[-sub,]
misuseClassifier<- ksvm(AttackType~.,data=misuseTrainingSet,type = 'C-svc', kernel = 'rbfdot')
misusePrediction<-predict(misuseClassifier, misuseTestSet[,-mCol])
confusionMatrix(misusePrediction,misuseTestSet[,mCol] )
