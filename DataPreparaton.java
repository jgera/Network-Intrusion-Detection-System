import java.io.*;
import java.util.ArrayList;

// This class represents Data Preparation
public class DataPreparaton {
	// List that stores all the data from files
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String args[]) throws FileNotFoundException,
			IOException {
		String FILE_LOCATION = "";
		// Number of maximum instances of each attack
		int noOfAttack = 250;
		int noOfNormal = 3000;
		// Filepath for built datasets
		String anomaly = FILE_LOCATION+"/Dataset_Anomaly.csv";
		String misuse = FILE_LOCATION+"/Dataset_Misuse.csv";
		// Filepath for Input files
		String attackPath = FILE_LOCATION+"/Optimized_";
		// An array that stores the types of attacks
		String[] attacks = { "Neptune", "NMap", "PortSweep", "Satan", "Smurf",
				"BufferOverflow", "FTPWrite", "GuessPassword", "Back",
				"Rootkit" };

		for (int i = 0; i < attacks.length; i++) {
			generateFile(attackPath + attacks[i] + ".csv", misuse, ", "
					+ attacks[i] + "\n", noOfAttack);
		}
		generateFile(attackPath + "Normal.csv", misuse, ", Normal\n",
				noOfNormal);
		printShuffle(list.toArray(new String[0]), misuse);

		list = new ArrayList<String>();
		for (int i = 0; i < attacks.length; i++) {
			generateFile(attackPath + attacks[i] + ".csv", anomaly,
					", Attack\n", noOfAttack);
		}
		generateFile(attackPath + "Normal.csv", anomaly, ", Normal\n",
				noOfNormal);
		printShuffle(list.toArray(new String[0]), anomaly);
	}

	// Reads inputs and creates a list that represents data in the file
	public static void generateFile(String input, String output, String column,
			int size) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(input));
		String line;
		int i = 0;
		while ((line = br.readLine()) != null && i < size) {
			list.add(line + column);
			i++;
		}
		br.close();
	}

	// swaps array elements i and j
	public static void swap(String[] a, int i, int j) {
		String swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	// takes as input an array of strings and rearranges them in random order
	public static void printShuffle(String[] a, String output)
			throws FileNotFoundException, UnsupportedEncodingException,
			IOException {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = i + (int) (Math.random() * (N - i)); // between i and N-1
			swap(a, i, r);
		}
		File file = new File(output);
		Writer writer = null;
		if (!file.exists()) {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(output), "utf-8"));
		} else
			writer = new PrintWriter(new BufferedWriter(new FileWriter(output,
					true)));
		// Attributes list
		writer.write("duration, protocol_type, service, flag, src_bytes, dst_bytes, land, wrong_fragment, urgent, hot, num_failed_logins, logged_in, num_compromised, root_shell, su_attempted, num_root, num_file_creations, num_shells, num_access_files, num_outbound_cmds, is_host_login, is_guest_login, count, srv_count, serror_rate, srv_error_rate, rerror_rate, srv_rerror_rate, same_srv_rate, diff_srv_rate, srv_diff_host_rate, dst_host_count, dst_host_srv_count, dst_host_same_srv_rate, dst_host_diff_srv_rate, dst_host_same_src_port_rate, dst_host_srv_diff_host_rate, dst_host_serror_rate, dst_host_srv_serror_rate, dst_host_rerror_rate, dst_host_srv_rerror_rate, AttackType\n");
		for (int i = 0; i < N; i++) {
			writer.write(a[i]);
		}
		writer.close();
	}
}
