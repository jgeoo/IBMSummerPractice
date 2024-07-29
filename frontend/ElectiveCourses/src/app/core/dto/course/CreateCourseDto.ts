export interface CreateCourseDto {
    name: string;
    maxStudentsAllowed: number;
    yearOfStudy: number;
    dayOfWeek: string;
    startHour: number;
    endHour: number;
}