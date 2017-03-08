-- Update event dates.


UPDATE F16_1_EVENTS
set Scheduled_DateTime = TO_DATE('15-02-2017', 'DD-MM-YYYY')
where Event_ID=1;

UPDATE F16_1_EVENTS
set Scheduled_DateTime = TO_DATE('30-05-2017', 'DD-MM-YYYY')
where Event_ID=3;


UPDATE F16_1_EVENTS
set Scheduled_DateTime = TO_DATE('24-02-2017', 'DD-MM-YYYY')
where Event_ID=5;

UPDATE F16_1_EVENTS
set Scheduled_DateTime = TO_DATE('01-05-2017', 'DD-MM-YYYY')
where Event_ID=6;

commit;