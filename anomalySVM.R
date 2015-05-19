library(kernlab)
library(caret)
anomaly<-read.csv("LOCATION_TO_DATA_FOLDER/data/Dataset_Anomaly.csv", na.strings=c(".", "NA", "", "?"), strip.white=TRUE, encoding="UTF-8")
aRow<-nrow(anomaly)
aCol<-ncol(anomaly)

sub<-sample(1:aRow,floor(0.66*aRow))
anomalyTrainingSet<- anomaly[sub,]
anomalyTestSet<- anomaly[-sub,]
anomalyClassifier<- ksvm(AttackType~.,data=anomalyTrainingSet,type = 'C-svc', kernel = 'rbfdot')
anomalyPrediction<-predict(anomalyClassifier, anomalyTestSet[,-aCol])
confusionMatrix(anomalyPrediction,anomalyTestSet[,aCol] )
