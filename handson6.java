
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;

public class handson6 {

    public static void main(String[] args) {

        Path path = Paths.get("employees.txt");
        Path copyPath = Paths.get("copy_employees.txt");

        // Menyimpan data karyawan
        ArrayList<String> employees = new ArrayList<>();

        try {

            // Memeriksa apakah file tersedia
            if (Files.notExists(path)) {
                System.out.println(
                    "File employees.txt tidak ditemukan!"
                );
                return;
            }

            // Membaca isi file
            try (var reader = Files.newBufferedReader(
                    path, StandardCharsets.UTF_8)) {

                String line;

                while ((line = reader.readLine()) != null) {
                    employees.add(line);
                }
            }

            // Menampilkan isi ArrayList
            System.out.println("=== DATA KARYAWAN ===");

            for (String employee : employees) {
                System.out.println(employee);
            }

            // Menyalin hasil pembacaan ke file baru
            Files.write(
                copyPath,
                employees,
                StandardCharsets.UTF_8
            );

            System.out.println(
                "\nData berhasil disimpan ke copy_employees.txt"
            );

        } catch (NoSuchFileException e) {

            System.out.println("File tidak ditemukan!");

        } catch (IOException e) {

            System.out.println(
                "Terjadi kesalahan: " + e.getMessage()
            );
        }
    }
}

