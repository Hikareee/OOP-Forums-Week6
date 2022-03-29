def givenFunction(x, y):

    return pow(pow(x, 4) + pow(y, 5), 0.5)

# Function to find the double integral value


def doubleIntegral(h, k, lx, ux, ly, uy):

    # z stores the table
    # ax[] stores the integral wrt y
    # for all x points considered
    z = [[None for i in range(50)]
         for j in range(50)]
    ax = [None] * 50

    # Calculating the number of points
    # in x and y integral
    nx = round((ux - lx) / h + 1)
    ny = round((uy - ly) / k + 1)

    # Calculating the values of the table
    for i in range(0, nx):
        for j in range(0, ny):
            z[i][j] = givenFunction(lx + i * h,
                                    ly + j * k)

    # Calculating the integral value
    # wrt y at each point for x
    for i in range(0, nx):
        ax[i] = 0
        for j in range(0, ny):

            if j == 0 or j == ny - 1:
                ax[i] += z[i][j]
            elif j % 2 == 0:
                ax[i] += 2 * z[i][j]
            else:
                ax[i] += 4 * z[i][j]

        ax[i] *= (k / 3)
    print("Result: " + ax[i])

