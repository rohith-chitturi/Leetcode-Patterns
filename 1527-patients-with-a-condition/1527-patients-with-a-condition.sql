select patient_id, patient_name, conditions
from patients
where conditions regexp '(^| )DIAB1[0-9]*($| )';