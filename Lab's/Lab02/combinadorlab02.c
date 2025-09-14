#include <stdio.h>
#include <string.h>
int main()
{
	char s1[100], s2[100], r[200];
	while (scanf("%s %s", s1, s2) ==2)
	{
		int y = strlen(s1);
		int x = strlen(s2);
		int i = 0, c = 0;
		for (i = 0; i < y && i < x; i++)
		{
			r[c++] = s1[i];
			r[c++] = s2[i];
		}

		for (; i < x; i++){
			r[c++] = s2[i];
		}

		for (; i < y; i++){
			r[c++] = s1[i];
		}

		r[c] = '\0';
		printf("%s\n", r);
	}
	return 0;
}