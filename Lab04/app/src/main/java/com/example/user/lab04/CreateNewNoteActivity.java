package com.example.user.lab04;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.user.lab04.core_ui.BaseActivity;

import java.util.Calendar;
import java.util.Date;


public class CreateNewNoteActivity extends BaseActivity {
    private static final String TAG = "CreateNewNoteActivity";

    ImageView ivMore;
    TextView tvTime;
    TextView tvDate;
    RelativeLayout rlType;
    TextView tvTags;
    TextView tvWeeks;
    RelativeLayout rlTune;

    String[] tags;
    boolean[] tagsCheck;

    String[] weeks;
    boolean[] weeksCheck;

    String[] defaults;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_new_note;
    }

    @Override
    protected void onUIReady() {
        setupUI();
    }

    private void setupUI() {
        ivMore = findViewById(R.id.iv_more);
        registerForContextMenu(ivMore);

        tvTime = findViewById(R.id.tv_time);
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(CreateNewNoteActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        tvTime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        tvDate = findViewById(R.id.tv_date);
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = Calendar.getInstance().get(Calendar.YEAR);
                int month = Calendar.getInstance().get(Calendar.MONTH);
                int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog;
                datePickerDialog = new DatePickerDialog(CreateNewNoteActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Log.d(TAG, "onDateSet: " + i + " " + i1 + " " + i2);
                        tvDate.setText(i2 + "/" + (i1 + 1) + "/" + i);
                    }
                }, year, month, day);
                datePickerDialog.setTitle("Select date");
                datePickerDialog.show();
            }
        });

        rlType = findViewById(R.id.rl_type);
        rlType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tags = new String[]{
                "Family",
                "Game",
                "Android",
                "VTC",
                "Friend"
        };
        tagsCheck = new boolean[]{
                false,
                false,
                false,
                false,
                false
        };
        tvTags = findViewById(R.id.tv_tags);
        tvTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewNoteActivity.this);
                builder.setMultiChoiceItems(tags, tagsCheck, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//                        Log.d(TAG, "onClick: " + tags[i] + " " + tagsCheck[i]);
                    }
                });

                builder.setCancelable(true);

                builder.setTitle("Choose your tags");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int dem = 0;
                        String t = new String("");
                        for (int j = 0; j < tags.length; j++) {
                            if (tagsCheck[j]) {
                                dem++;
                                t = t + tags[j] + ", ";
                            }
                        }

                        if (dem == 0) {
                            tvTags.setText("Click to choose your tags");
                        } else {
                            t = t.substring(0, t.length() - 2);

                            tvTags.setText(t);
                        }
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvTags.setText("Click to choose your tags");
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        tvWeeks = findViewById(R.id.tv_weeks);
        weeks = new String[] {
                "Mon",
                "Tue",
                "Wed",
                "Thu",
                "Sat",
                "Sun"
        };
        weeksCheck = new boolean[] {
                false,
                false,
                false,
                false,
                false,
                false,
                false
        };
        tvWeeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewNoteActivity.this);
                builder.setMultiChoiceItems(weeks, weeksCheck, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    }
                });

                builder.setCancelable(true);

                builder.setTitle("Choose your date");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int dem = 0;
                        String t = new String("");
                        for (int j = 0; j < weeks.length; j++) {
                            if (weeksCheck[j]) {
                                dem++;
                                t = t + weeks[j] + ", ";
                            }
                        }

                        if (dem == 0) {
                            tvWeeks.setText("Click to choose your date");
                        } else {
                            t = t.substring(0, t.length() - 2);

                            tvWeeks.setText(t);
                        }
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvWeeks.setText("Click to choose your weeks");
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        rlTune = findViewById(R.id.rl_tune);
        defaults = new String[] {
                "Nexus Tune",
                "Winphone Tune",
                "Peep Tune",
                "Nokia Tune",
                "Etc"
        };
        rlTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(CreateNewNoteActivity.this, rlTune);
                popupMenu.getMenuInflater().inflate(R.menu.tune_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.from_defaults)
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewNoteActivity.this);
                            builder.setTitle("Choose your Tune");
                            builder.setSingleChoiceItems(defaults, -1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Log.d(TAG, "onClick: " + defaults[i]);
                                }
                            });

                            builder.setCancelable(true);
                            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });

                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });

                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.iv_more)
            getMenuInflater().inflate(R.menu.three_dot_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.cancel:
                onBackPressed();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
