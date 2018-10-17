package com.ibrahimyousre.resumebuilder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.ibrahimyousre.resumebuilder.datamodel.Project;
import com.ibrahimyousre.resumebuilder.datamodel.ResumeEvent;
import com.ibrahimyousre.resumebuilder.datamodel.School;
import com.ibrahimyousre.resumebuilder.helper.TextChangeListener;

public class EditActivity extends AppCompatActivity {
    public static final String EXTRA_TYPE = "type";
    public static final String TYPE_PROJECT = "project";
    public static final String TYPE_SCHOOL = "school";
    public static final String TYPE_EXPERIENCE = "experience";
    public static final String TYPE_REFERENCES = "references";

    private int id = -1;
    private String title = "", detail = "", subtitle = "", description = "";
    private String shortdescription = "", longdescription = "";

    public static final String FIELD_ID = "id";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_DETAIL = "details";
    public static final String FIELD_SUBTITLE = "subtitle";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_SHORTDESCRIPTION = "shortdescription";
    public static final String FIELD_LONGDESCRIPTION = "longdescription";

    boolean subtitleEnabled = true;
    boolean detailEnabled = true;

    EditText titleEditText;
    EditText detailEditText;
    EditText subtitleEditText;
    EditText descriptionEditText;
    EditText shortdescriptionEditText;
    EditText longdescriptionEditText;

    TextInputLayout titleEditTextLayout;
    TextInputLayout detailEditTextLayout;
    TextInputLayout subtitleEditTextLayout;
    TextInputLayout descriptionEditTextLayout;
    TextInputLayout shortdescriptionEditTextLayout;
    TextInputLayout longdescriptionEditTextLayout;

    public static Intent setData(Intent intent, int id, ResumeEvent resumeEvent) {
        intent.putExtra(FIELD_ID, id);
        intent.putExtra(FIELD_TITLE, resumeEvent.getTitle());
        intent.putExtra(FIELD_DETAIL, resumeEvent.getDetail());
        intent.putExtra(FIELD_SUBTITLE, resumeEvent.getSubtitle());
        intent.putExtra(FIELD_DESCRIPTION, resumeEvent.getDescription());
        intent.putExtra(FIELD_SHORTDESCRIPTION, resumeEvent.getShortDescription());
        intent.putExtra(FIELD_LONGDESCRIPTION, resumeEvent.getLongDescription());
        return intent;
    }

    public static Intent getProjectIntent(Context context) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra(EXTRA_TYPE, TYPE_PROJECT);
        return intent;
    }

    public static Intent getSchoolIntent(Context context) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra(EXTRA_TYPE, TYPE_SCHOOL);
        return intent;
    }

    public static Intent getExperienceIntent(Context context) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra(EXTRA_TYPE, TYPE_EXPERIENCE);
        return intent;
    }
    public static Intent getReferencesIntent(Context context) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra(EXTRA_TYPE, TYPE_REFERENCES);
        return intent;
    }

    public static ResumeEvent getEvent(Intent intent) {
        String title = intent.getStringExtra(FIELD_TITLE);
        String detail = intent.getStringExtra(FIELD_DETAIL);
        String subtitle = intent.getStringExtra(FIELD_SUBTITLE);
        String description = intent.getStringExtra(FIELD_DESCRIPTION);
        String shortdescription = intent.getStringExtra(FIELD_SHORTDESCRIPTION);
        String longdescription = intent.getStringExtra(FIELD_LONGDESCRIPTION);
        return new ResumeEvent(title, detail, subtitle, description, null, null,shortdescription,longdescription);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        switch (intent.getStringExtra(EXTRA_TYPE)) {
            case TYPE_PROJECT:
                setContentView(R.layout.activity_edit_project);
                subtitleEnabled = false;
                getSupportActionBar().setTitle("Achievements");
                break;
            case TYPE_SCHOOL:
                setContentView(R.layout.activity_edit_school);
                getSupportActionBar().setTitle("Education");
                break;
            case TYPE_EXPERIENCE:
                setContentView(R.layout.activity_edit_experience);
                getSupportActionBar().setTitle("Experience");
                break;
            case TYPE_REFERENCES:
                setContentView(R.layout.activity_edit_references);
                getSupportActionBar().setTitle("References");
                break;
        }
        titleEditText = findViewById(R.id.input_title);
        detailEditText = findViewById(R.id.input_detail);
        subtitleEditText = findViewById(R.id.input_subtitle);
        descriptionEditText = findViewById(R.id.input_description);
        shortdescriptionEditText = findViewById(R.id.input_passing_date);
        longdescriptionEditText = findViewById(R.id.input_end_date);

        titleEditTextLayout = findViewById(R.id.input_layout_title);
        detailEditTextLayout = findViewById(R.id.input_layout_detail);
        subtitleEditTextLayout = findViewById(R.id.input_layout_subtitle);
        descriptionEditTextLayout = findViewById(R.id.input_layout_description);
        shortdescriptionEditTextLayout = findViewById(R.id.input_layout_passing_date);
        longdescriptionEditTextLayout = findViewById(R.id.input_layout_end_date);

        titleEditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                title = s.toString();
            }
        });
        detailEditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                detail = s.toString();
            }
        });
        subtitleEditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                subtitle = s.toString();
            }
        });
        descriptionEditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                description = s.toString();
            }
        });
        shortdescriptionEditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                shortdescription = s.toString();
            }
        });
        longdescriptionEditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                longdescription = s.toString();
            }
        });
        if (intent.hasExtra(FIELD_ID)) {
            id = intent.getIntExtra(FIELD_ID, -1);
            title = intent.getStringExtra(FIELD_TITLE);
            detail = intent.getStringExtra(FIELD_DETAIL);
            subtitle = intent.getStringExtra(FIELD_SUBTITLE);
            description = intent.getStringExtra(FIELD_DESCRIPTION);
            shortdescription = intent.getStringExtra(FIELD_SHORTDESCRIPTION);
            longdescription = intent.getStringExtra(FIELD_LONGDESCRIPTION);

            titleEditText.setText(title);
            detailEditText.setText(detail);
            subtitleEditText.setText(subtitle);
            descriptionEditText.setText(description);
            shortdescriptionEditText.setText(shortdescription);
            longdescriptionEditText.setText(longdescription);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_save) {
            if (validInput()) {
                setResult(RESULT_OK, getResultIntent());
                finish();
                return true;
            } else {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean validInput() {
        boolean result = true;
        if (TextUtils.isEmpty(titleEditText.getText())) {
            titleEditTextLayout.setError("This field is required");
            result = false;
        }

        if (TextUtils.isEmpty(descriptionEditText.getText())) {
            descriptionEditTextLayout.setError("This field is required");
            result = false;
        }
        if (subtitleEnabled && TextUtils.isEmpty(subtitleEditText.getText())) {
            subtitleEditTextLayout.setError("This field is required");
            result = false;
        }


        return result;
    }

    private Intent getResultIntent() {
        Intent intent = new Intent();
        if (id != -1) {
            intent.putExtra(FIELD_ID, id);
        }
        intent.putExtra(FIELD_TITLE, title);
        intent.putExtra(FIELD_DETAIL, detail);
        intent.putExtra(FIELD_SUBTITLE, subtitle);
        intent.putExtra(FIELD_DESCRIPTION, description);
        intent.putExtra(FIELD_SHORTDESCRIPTION, shortdescription);
        intent.putExtra(FIELD_LONGDESCRIPTION, longdescription);
        return intent;
    }
}
