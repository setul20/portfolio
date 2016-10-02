struct point{
	   int x, y;
};
struct rect{
	   struct point ne, se, sw, nw;
};

/* This method initializes a rectangle structure.  It does not declare the structure.
 * You must read in user input to obtain the x and y coordinates of the south east,
 * north west, north east, and south east points of the rectangle.  You can assume
 * that the user will pass in integers to the method.  We are not concerned with the
 * validity of the integers in this method.  ValidateRect() will handle that.
 */
extern void InitRect(struct rect *rectangle);

/* This method validates a rectangle that has already been initialized. It validates
 * the rectangle by making sure that the edges of the rectangle are parallel to both
 * the x axis and the y axis (i.e. the rectangle is not tilted/rotated in any way).
 */
extern int ValidateRect(struct rect rectangle);

/* This method calculates the area of a rectangle.  It assumes that only valid (no
 * rotation) rectangles are passed in as parameters.
 */
extern int RectArea(struct rect rectangle);

/* This method rotates the rectangle passed in by 90 degrees clockwise. This function
 * modifies the rectangle that is passed in -- it does not return a rectangle. A call
 * to this method does not make a rectangle invalid. If a valid rectangle is passed in,
 * the result is still a valid rectangle.
 */
extern void RotateRect(struct rect *rectangle);

/* This method prints a rectangle.  See the examples in the lab description for how to 
 * print
 */
extern void PrintRect(struct rect rectangle);
