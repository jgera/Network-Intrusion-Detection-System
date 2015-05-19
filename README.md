This is the team project on which I had worked on at RIT(Rochester Institute of Technology).

Team Members:  Saunil Desai, Ravina Dandekar, Pratik Mehta

# NIDS
•	We have Designed and developed an anomaly and misuse based intrusion detection system using neural networks.

Technologies used: Java Weka and R

Java is used to prepare datasets.
R is used implement a neural network.
Weka is used for data cleaning.

We created two files; one to detect anomaly based attacks and one to detect misuse based attacks.

These files have about 4500 instances the input is divided into a Training Data Set (75%) to train our Neural Network and Test Data Set (25%) on our trained Neural Network.

Data Preprocessing
1. It is carried out using Weka. For details on how the data was preprocessed refer Page 4 of the report.pdf file.

Data Preparation
1. DataPreparation.java file is used to prepare data. Data is prepared by extracting rows randomly from each of the files named with Optimized_'name_of_attack' in the data folder. For eg: Optimized_FTPWrite.
2. To run the code in DataPreparation.java file. Open it and set the String value for FILE_LOCATION attribute on line 11 to the directory where the attack files would be stored as .../data/ .
3. The excel files generated after data preparation are Dataset_Anomaly and Dataset_Misuse which would late be used by the neural network.

Neural Network
1. Change the "LOCATION_TO_DATA_FOLDER" on line 3 in the anomalySVM.R and misuseSVM.R to the location of the project folder when in use.
2. Then you are ready to use R to execute the neural network and generate results.

For details on results and any specific information please refer the report.pdf file.
