package com.example.projet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpFragment extends Fragment {
    FirebaseDatabase database;
    DatabaseReference reference;

    EditText editTextUsername, editTextEmail, editTextPassword;
    Button buttonSignUp, buttonReturnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        editTextUsername = view.findViewById(R.id.editTextUsernameSignUp);
        editTextEmail = view.findViewById(R.id.editTextEmailSignUp);
        editTextPassword = view.findViewById(R.id.editTextPasswordSignUp);
        buttonSignUp = view.findViewById(R.id.buttonSignUp);
        buttonReturnLogin = view.findViewById(R.id.buttonReturnLogin);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                // Create a new user object
                helperuser user = new helperuser(email, username, password);

                // Store the user object in Firebase Realtime Database
                reference.child(username).setValue(user);

                // Display a toast message to confirm sign-up
                Toast.makeText(getActivity(), "Sign-up successful!", Toast.LENGTH_SHORT).show();

                // Switch to the library fragment
                goToLibraryFragment();
            }
        });

        buttonReturnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Return to the login fragment
                goBackToLoginFragment();
            }
        });

        return view;
    }

    private void goToLibraryFragment() {
        // Create an instance of LibraryFragment
        library libraryFragment = new library();

        // Replace the current fragment with LibraryFragment
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, libraryFragment)
                .addToBackStack(null)
                .commit();
    }

    private void goBackToLoginFragment() {
        // Create an instance of LoginFragment
        login loginFragment = new login();

        // Replace the current fragment with LoginFragment
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, loginFragment)
                .addToBackStack(null)
                .commit();
    }
}
