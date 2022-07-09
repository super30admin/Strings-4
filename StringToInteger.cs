using System;
using System.Collections.Generic;
using System.Text;

namespace Strings
{
    public class StringToInteger
    {
        /*
         * T.C: O(N) where n is chars in string
         * S.C: O(1) 
         */
        public int MyAtoi(string s)
        {
            s = s.Trim();

            if (s == null || s.Length == 0) return 0;

            char sign = '+';

            if (s[0] != '+' && s[0] != '-' && !Char.IsNumber(s[0]))
            {

                return 0;
            }

            int limit = 214748364;
            int result = 0;

            if (s[0] == '-')
            {
                sign = '-';
            }

            for (int i = 0; i < s.Length; i++)
            {
                if (Char.IsNumber(s[i]))
                {
                    if (sign == '-')
                    {
                        if (result > limit)
                        {
                            return int.MinValue;
                        }
                        else if (result == limit)
                        {
                            if ((s[i] - '0') > 8)
                                return int.MinValue;
                        }

                    }
                    else
                    {
                        if (result > limit)
                        {
                            return int.MaxValue;
                        }
                        else if (result == limit)
                        {
                            if ((s[i] - '0') > 7)
                                return int.MaxValue;
                        }
                    }

                    result = result * 10 + (s[i] - '0');

                }
                else if (i != 0 && !char.IsNumber(s[i]))
                {
                    break;
                }

            }

            if (sign == '-')
            {
                return result = result * -1;
            }

            return result;

        }
    }
}
