package com.example.projet;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends Fragment {
    FirebaseDatabase database;
    DatabaseReference reference;

    EditText editTextUsername, editTextPassword;
    Button buttonLogin, buttonSignUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        editTextUsername = view.findViewById(R.id.editTextUsernameLogin);
        editTextPassword = view.findViewById(R.id.editTextPasswordLogin);
        buttonLogin = view.findViewById(R.id.buttonLogin);
        buttonSignUp = view.findViewById(R.id.buttonSignUp);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the username and password entered by the user
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Check if the username and password are empty
                if (username.isEmpty() || password.isEmpty()) {
                    // Show a toast message indicating that username or password is empty
                    Toast.makeText(getActivity(), "Please enter username and password", Toast.LENGTH_SHORT).show();
                    return; // Return without attempting login
                }

                // Check the user credentials in Firebase Realtime Database
                reference.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            // User exists, check the password
                            helperuser user = snapshot.getValue(helperuser.class);
                            if (user != null && user.getPassword().equals(password)) {
                                // Password matches, login successful
                                // You can perform additional actions here if needed
                                // For example, navigating to another fragment
                                library libraryFragment = new library();

                                // Replace the current fragment with LibraryFragment
                                requireActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.frame_layout, libraryFragment)
                                        .addToBackStack(null)
                                        .commit();
                            } else {
                                // Password does not match, show an error message
                                Toast.makeText(getActivity(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // User does not exist, show an error message
                            Toast.makeText(getActivity(), "User does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle database error if needed
                        Toast.makeText(getActivity(), "Database error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to the sign-up fragment
                signUpFragment();
            }
        });

        return view;
    }

    private void signUpFragment() {
        // Create an instance of SignUpFragment
        SignUpFragment signUpFragment = new SignUpFragment();

        // Replace the current fragment with SignUpFragment
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, signUpFragment)
                .addToBackStack(null)
                .commit();
    }
}
